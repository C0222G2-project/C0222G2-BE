package com.coffee.repository;

import com.coffee.model.feedback.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function:  page , search
     *
     * @param pageable
     * @param feedbackDate
     * @param creator
     * @return
     */

    @Query(value = " select feedback.id, feedback.code, feedback.content, feedback.creator, feedback.email,  " +
            " feedback.feedback_date, feedback.image, feedback.rating, feedback.is_deleted  " +
            " from feedback where feedback.creator like :creator and feedback.feedback_date like :feedbackDate and feedback.is_deleted = 0 ", nativeQuery = true,
            countQuery = " select count (*) from ( select feedback.id, feedback.code, feedback.content, feedback.creator, feedback.email,  " +
                    " feedback.feedback_date, feedback.image, feedback.rating, feedback.is_deleted  " +
                    " from feedback where feedback.creator like :creator and feedback.feedback_date like :feedbackDate and feedback.is_deleted = 0 ) feedback")
    Page<Feedback> findAllFeedback(Pageable pageable,
                                   @Param("feedbackDate") String feedbackDate,
                                   @Param("creator") String creator);

    /**
     * Created by : LuanTV
     * Date created: 08/09/2022
     * function: find by id feedback
     *
     * @param id
     * @return
     */

    @Query(value = " select feedback.id, feedback.code, feedback.content, feedback.creator, feedback.email,  " +
            " feedback.feedback_date, feedback.image, feedback.rating, feedback.is_deleted  " +
            " from feedback where feedback.id =:idDetail and feedback.is_deleted = 0 ", nativeQuery = true)
    Optional<Feedback> findFeedbackById(@Param("idDetail") int id);

}
