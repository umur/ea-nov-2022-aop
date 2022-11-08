package com.example.productreview.entity.DTO;

import com.example.productreview.entity.uni_and_bi_directional.ActivityLog;
import com.example.productreview.entity.uni_and_bi_directional.Product;
import com.example.productreview.entity.uni_and_bi_directional.Review;
import com.example.productreview.entity.uni_and_bi_directional.User_;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {

    public UserAddressDTO userToDTO(User_ user){
        UserAddressDTO userAddressDTO = new UserAddressDTO();
        userAddressDTO.setCity(user.getAddress().getCity());
        userAddressDTO.setStreet(user.getAddress().getStreet());
        userAddressDTO.setEmail(user.getEmail());
        userAddressDTO.setFirstName(user.getFirstName());
        userAddressDTO.setLastName(user.getLastName());

        return userAddressDTO;
    }

    public ProductDTO productToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setCategory(product.getCategory());
        productDTO.setName(product.getName());
        productDTO.setRating(product.getRating());
        productDTO.setReviews(product.getReviews());

        return productDTO;
    }

    public ReviewDTO reviewToDTO(Review review){
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewId(review.getId());
        reviewDTO.setFirstName(review.getUser_().getFirstName());
        reviewDTO.setLastName(review.getUser_().getLastName());
        reviewDTO.setPrice(review.getProduct().getPrice());
        reviewDTO.setProductName(review.getProduct().getName());
        reviewDTO.setComment(review.getComment());

        return reviewDTO;
    }

    public ActivityLogDTO activityLogtoDTO(ActivityLog activityLog){
        ActivityLogDTO activityLogDTO = new ActivityLogDTO();
        activityLogDTO.setDate(activityLog.getDate());
        activityLogDTO.setDuration(activityLog.getDuration());
        activityLogDTO.setOperation(activityLog.getOperation());
        activityLogDTO.setId(activityLog.getId());

        return activityLogDTO;
    }


}
