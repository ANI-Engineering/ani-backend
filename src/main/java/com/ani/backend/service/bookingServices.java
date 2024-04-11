package com.ani.backend.service;
import com.ani.backend.dao.bookingModel;
import com.ani.backend.repositories.bookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class bookingServices {
        @Autowired
    
      private bookingRepo bookingrepo;
    
      @SuppressWarnings(" null")
    
      public bookingModel creatbookingmodel(bookingModel bookingmodel){
        return bookingrepo.save(bookingmodel);   //add the user to the database and save it 
      }
    
      @SuppressWarnings(" null") 
      public List<bookingModel> creatbookingmodel(List<bookingModel> bookingmodel){
        return bookingrepo.saveAll(bookingmodel); // add multiple users at once  
      }
      
      
    
      public bookingModel getbookingModelById(int bookingID){
        return bookingrepo.findById(bookingID).orElse(null);// return a user with that id if exists else null
      }
    
      public List<bookingModel> findBookingsByUserId(int userId) {
        return bookingrepo.findByUserId(userId); // return all bookings for this user
    }
    
      public List<bookingModel> getbookings(){
        return bookingrepo.findAll(); //return all users in the database
      }
    
    
      public bookingModel updatebookingModel(bookingModel bookingmodel){
        bookingModel oldbookingModel = null; // get the old data from the database using the id  of the object passed to this function
        Optional<bookingModel> optionalbookingmodel = bookingrepo.findById(bookingmodel.getBookingID());
        if(optionalbookingmodel.isPresent()){ // if the user is present in the database 
            oldbookingModel = optionalbookingmodel.get();
            oldbookingModel.setUserId(bookingmodel.getUserId()); 
            oldbookingModel.setPropertyId(bookingmodel.getPropertyId());//  store the data from the datbase into the variable  olduser                     
            oldbookingModel.setBookingDate(bookingmodel.getBookingDate());
            oldbookingModel.setCheckInDate(bookingmodel.getCheckInDate());
            oldbookingModel.setCheckOutDate(bookingmodel.getCheckOutDate());
            oldbookingModel.setInfantCount(bookingmodel.getInfantCount()); // update the fields of the user.
            oldbookingModel.setChildCount(bookingmodel.getChildCount());
            oldbookingModel.setAdultCount(bookingmodel.getAdultCount());  
            oldbookingModel.setStatus(bookingmodel.getStatus());
            bookingrepo.save(oldbookingModel);
    
        }else{
            return new bookingModel();
        }
        return oldbookingModel; //  return the updated user 
    
      } 
      public String  cancelbookingModelById(int bookingId){ 
        bookingrepo.deleteById(bookingId);  // delete the user with this id from the database    
        return  "Booking cancle succesfully"; //  return success message 
      }
    }
    
    
    
    // @Autowired
    // bookingRepo testRepository;

    // public List<bookingModel> getAllTests(){
    //     return testRepository.findAll();
    // }

    // public void saveTest(bookingModel test){
    //     testRepository.save(test);
    // }

