package com.coffee.controller;

import com.coffee.dto.FeedbackDto;
import com.coffee.model.feedback.Feedback;
import com.coffee.service.feedback.IFeedbackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
