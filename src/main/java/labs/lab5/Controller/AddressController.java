package labs.lab5.Controller;

import labs.lab5.Anotations.ExecutionTime;
import labs.lab5.Entity.UniAddress;
import labs.lab5.Service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
@AllArgsConstructor
public class AddressController {

    AddressService addressService;

    @GetMapping
    @ExecutionTime
    public ResponseEntity<UniAddress> getAddresses(){
        return new ResponseEntity(this.addressService.getAddresses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniAddress> getAddressById(@PathVariable String id){
        UniAddress add = this.addressService.getAddressById(id);
        if(add != null)
            return new ResponseEntity<>(add, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addAddress(UniAddress add){
        UniAddress a = this.addressService.saveAddress(add);
        if(a != null)
            return new ResponseEntity<>("successfully added address", HttpStatus.OK);
        else
            return new ResponseEntity<>("unable to add address", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity updateAddress(@RequestBody UniAddress add ){
        UniAddress a = this.addressService.saveAddress(add);
        if(a != null)
            return new ResponseEntity<>(a, HttpStatus.OK);
        else
            return new ResponseEntity<>("unable to update address", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable String id){
        this.addressService.deleteAddressById(id);
        return new ResponseEntity<>("address deleted", HttpStatus.OK);
    }
}
