package com.coffee.service.feedback;

import com.coffee.model.feedback.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFeedbackService {
    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function: page section, search
     *
     * @param pageable
     * @param creator
     * @param feedbackDate
     * @return
     */
    Page<Feedback> findAllFeedback(Pageable pageable, String creator, String feedbackDate);

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function: find by id feedback
     *
     * @param id
     * @return
     */

    Optional<Feedback> findFeedbackById(int id);
}
