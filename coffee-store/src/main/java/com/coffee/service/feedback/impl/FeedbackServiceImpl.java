package com.coffee.service.feedback.impl;

import com.coffee.model.feedback.Feedback;
import com.coffee.repository.IFeedbackRepository;
import com.coffee.service.feedback.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
     * @param creattor
     * @param feedbackDate
     * @return
     */

    @Override
    public Page<Feedback> findAllFeedback(Pageable pageable, String creattor, String feedbackDate) {
        return feedbackRepository.findAllFeedback(pageable, "%" + creattor + "%", "%" + feedbackDate + "%");
    }

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function: find by id feedback
     *
     * @param id
     * @return
     */

    @Override
    public Feedback findFeedbackById(int id) {
        return feedbackRepository.findFeedbackById(id);
    }
}
