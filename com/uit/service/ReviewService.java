/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uit.service;

import com.uit.dao.ReviewDao;
import com.uit.entity.Review;
import java.util.List;

/**
 *
 * @author vunguyen
 */
public class ReviewService {

    ReviewDao reviewDao;

    public ReviewService() {
        reviewDao = new ReviewDao();
    }

    public List<Review> listAllreview() {
        return reviewDao.listAllreview();
    }

    public List<Review> listAllreviewbyBookId(long id) {
        return reviewDao.listAllreviewbyBookId(id);
    }

    public void addReview(Review review) {
        reviewDao.addReview(review);
    }

    public boolean checkReviewDuplicate(long bookId, long customerId) {
        return reviewDao.checkReviewDuplicate(bookId, customerId);
    }
    
    public boolean checkReview(long bookId, long customerId){
        return reviewDao.checkReview(bookId, customerId);
    }
}
