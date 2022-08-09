package com.coffee.service.feedback;

import com.coffee.model.feedback.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFeedbackService {
    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function: page section, search
     *
     * @param pageable
     * @param creattor
     * @param feedbackDate
     * @return
     */
    Page<Feedback> findAllFeedback(Pageable pageable, String creattor, String feedbackDate);

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function: find by id feedback
     *
     * @param id
     * @return
     */

    Feedback findFeedbackById(int id);
}
