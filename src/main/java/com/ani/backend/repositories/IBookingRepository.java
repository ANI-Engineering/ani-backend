package com.ani.backend.repositories;

import com.ani.backend.dao.Booking;
import com.ani.backend.dao.PropertyReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {

    @Modifying
    @Query(value = "EXEC appl_security.rlsec.sw_helpdesk_update_user_details_new @userId = :userId, @vuid = :vuid, @phonenumber  = :phone,"
            + " @username  = :username, @emailid = :email, @employeetype  = :employeeType, @thirdpartytype = :thirdPartyType, @szGroups  = :szGroups,"
            + " @vendors  = :vendors,"
            + " @contactphonecountry  = :contactPhoneCountry, @employeeposition  = :employeePosition, @pguidlist  = :pguidList", nativeQuery = true)
    void helpDeskUpdateProfile(@Param("userId") @Nullable String userId,
                               @Param("vuid") String vuid, @Param("phone") @Nullable String phone,
                               @Param("username") @Nullable String userName,
                               @Param("email") @Nullable String email,
                               @Param("employeeType") int employeeType,
                               @Param("thirdPartyType") int thirdPartyType,
                               @Param("szGroups") @Nullable String szGroups,
                               @Param("vendors") @Nullable String vendors,
                               @Param("contactPhoneCountry") @Nullable String contactPhoneCountry,
                               @Param("employeePosition") @Nullable Integer employeePosition,
                               @Param("pguidList") @Nullable String pguidList);


}
