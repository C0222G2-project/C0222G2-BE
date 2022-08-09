package com.coffee.service.feedback.impl;

import com.coffee.model.feedback.Feedback;
import com.coffee.repository.feedback.IFeedbackRepository;
import com.coffee.service.feedback.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

    @Autowired
    private IFeedbackRepository feedbackRepository;

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function:  page section, search
     *
     * @param pageable
     * @param creator
     * @param feedbackDate
     * @return Page<Feedback>
     */

    @Override
    public Page<Feedback> findAllFeedback(Pageable pageable, String creator, String feedbackDate) {
        return feedbackRepository.findAllFeedback(pageable, "%" + creator + "%", "%" + feedbackDate + "%");
    }

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function: find by id feedback
     *
     * @param id
     * @return Feedback
     */

    @Override
    public Optional<Feedback> findFeedbackById(int id) {
        return feedbackRepository.findFeedbackById(id);
    }

    /**
     * Created by: DiepTT
     * Date created: 09/08/2022
     * Function: Create feedback (User send feedback)
     */
    @Override
    public void createFeedback(Feedback feedback) {

        Integer lastId = this.feedbackRepository.findLastFeedbackId();
        if (lastId == null) {
            lastId = 0;
        }
        int curId = lastId + 1;
        if (curId < 10) {
            feedback.setCode("FB000" + curId);
        }
        if (curId >= 10 && curId < 100) {
            feedback.setCode("FB00" + curId);
        }
        if (curId >= 100 && curId < 1000) {
            feedback.setCode("FB0" + curId);
        }
        if (curId >= 1000) {
            feedback.setCode("FB" + curId);
        }

        Date curDate = new Date(System.currentTimeMillis());
        feedback.setFeedbackDate(curDate);

        this.feedbackRepository.saveFeedback(feedback.getCode(), feedback.getFeedbackDate(), feedback.getCreator(),
                feedback.getEmail(), feedback.getContent(), feedback.getRating(), feedback.getImage());
    }
}