package com.coffee.controller;


import com.coffee.model.feedback.Feedback;
import com.coffee.service.feedback.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackRestController {


    @Autowired
    private IFeedbackService feedbackService;

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
     * @return
     */


    @GetMapping("/page")
    public ResponseEntity<Page<Feedback>> getAllFeedback(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam Optional<String> searchCreator,
            @RequestParam Optional<String> searchFeedbackDate){
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("rating").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("rating").descending();
        }
        Pageable pageable = PageRequest.of(page, size, sortable);
        String creattor = searchCreator.orElse("");
        String feedbackDate = searchFeedbackDate.orElse("");
        Page<Feedback> feedbackPage = feedbackService.findAllFeedback(pageable,creattor,feedbackDate);
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
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable int id) {
        Feedback feedback = feedbackService.findFeedbackById(id);
        if(feedback == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }
}
