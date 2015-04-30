package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.OrganizationRepository;

/**
 * Created by Ugo on 30/04/2015.
 */
@Component
public class OrganizationService extends AbstractService {
    @Autowired protected OrganizationRepository organizationRepository;

}
