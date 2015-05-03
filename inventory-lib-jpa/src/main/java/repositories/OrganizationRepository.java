package repositories;

import domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import util.MembershipType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Ugo on 30/04/2015.
 */
public interface OrganizationRepository extends JpaRepository<Organization,Serializable> {

    public List<Organization> findByOrganizationUUId(String organizationUUId);
    public List<Organization> findByOrganizationName(String organizationName);
    public List<Organization> findByMembershipType(MembershipType membershipType);
    public List<Organization> findByValidityTo(Date date);
}
