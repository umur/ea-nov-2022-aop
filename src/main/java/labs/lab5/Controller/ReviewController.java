package labs.lab5.Controller;

import labs.lab5.Anotations.ExecutionTime;
import labs.lab5.Entity.UniReview;
import labs.lab5.Service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    ReviewService reviewService;

    public ReviewController(ReviewService rs){
        this.reviewService = rs;
    }

    @GetMapping
    @ExecutionTime
    public ResponseEntity getReviews(){
        return new ResponseEntity(this.reviewService.getReviews(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getReviewById(@PathVariable String id){
        UniReview rev = this.reviewService.getReviewById(id);
        if(rev != null)
                return new ResponseEntity<>(rev, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/filter/product")
    public ResponseEntity<List<UniReview>> getReviewsByProductId(@RequestParam String id){
        return new ResponseEntity<>(this.reviewService.getReviewsByProductId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addReview(UniReview r){
        UniReview rev = this.reviewService.addReview(r);
        if(rev != null)
            return new ResponseEntity<>("successfully added review", HttpStatus.OK);
        else
            return new ResponseEntity<>("unable to add review", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity updateReviewById(@RequestBody UniReview r){
        UniReview rev = this.reviewService.updateReview(r);
        if(rev != null)
            return new ResponseEntity<>(rev, HttpStatus.OK);
        else
            return new ResponseEntity<>("unable to update review", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReviewById(@PathVariable String id){
        this.reviewService.deleteReviewById(id);
        return new ResponseEntity<>("review deleted", HttpStatus.OK);
    }

}
