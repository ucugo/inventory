package security;

import domain.InventoryUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import repositories.UserRepository;
import util.AccountStatus;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ugo on 03/05/2015.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        userName = StringUtils.trim(userName);
        InventoryUser inventoryUser = userRepository.findByEmailAddress(userName).get(0);

        return loadUser(inventoryUser);
    }

    private User loadUser(InventoryUser inventoryUser){
        if (inventoryUser == null){
            throw new UsernameNotFoundException("user not found");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if(inventoryUser.isAdmin()){
            authorities.add(new SimpleGrantedAuthority(InventoryUser.ADMIN_ROLE));
        }else if(inventoryUser.isManager()){
            authorities.add(new SimpleGrantedAuthority(InventoryUser.MANAGER_ROLE));
        }else if(inventoryUser.isSales()){
            authorities.add(new SimpleGrantedAuthority(InventoryUser.SALES_ROLE));
        }
        log.info("UserId:[{}] Username:[{}] authorities:[{}]",new Object[]{inventoryUser.getId(),inventoryUser.getEmailAddress(),authorities});
        return new User(inventoryUser.getEmailAddress(), inventoryUser.getPassword(), true,true, true, inventoryUser.getAccountStatus()== AccountStatus.APPROVED, authorities);
    }
}
