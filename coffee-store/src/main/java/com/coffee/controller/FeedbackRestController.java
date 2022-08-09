package com.coffee.controller;

import com.coffee.dto.FeedbackDto;
import com.coffee.model.feedback.Feedback;
import com.coffee.service.feedback.IFeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackRestController {

    @Autowired
    private IFeedbackService feedbackService;

    /**
     * Created by: DiepTT
     * Date created: 09/08/2022
     * Function: Create feedback (User send feedback)
     *
     * @param feedbackDto
     * @param bindingResult
     * @return feedback in the database
     */
    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createFeedback(
            @Validated @RequestBody FeedbackDto feedbackDto,
            BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }


        Feedback feedback = new Feedback();

        BeanUtils.copyProperties(feedbackDto, feedback);

        this.feedbackService.createFeedback(feedback);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function:  page section, search, sort
     * if page feedback "" : NO_CONTENT
     *
     * @param page
     * @param size
     * @param sort
     * @param searchCreator
     * @param searchFeedbackDate
     * @return Page<Feedback>
     */


    @GetMapping("/page")
    public ResponseEntity<Page<Feedback>> getAllFeedback(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam Optional<String> searchCreator,
            @RequestParam Optional<String> searchFeedbackDate){
        Sort sortable = Sort.by(sort);
        if (sort.equals("ASC")) {
            sortable = Sort.by("id").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("id").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        String creator = searchCreator.orElse("");
        String feedbackDate = searchFeedbackDate.orElse("");
        Page<Feedback> feedbackPage = feedbackService.findAllFeedback(pageable,creator,feedbackDate);
        if (feedbackPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(feedbackPage, HttpStatus.OK);
        }
    }

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     *function: find by id feedback
     * if id feedback null : NO_CONTENT
     *
     *
     * @param id
     * @return  Feedback
     */

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable int id) {
        Optional<Feedback> feedback = feedbackService.findFeedbackById(id);
        if(!feedback.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(feedback.get(), HttpStatus.OK);
    }
}
