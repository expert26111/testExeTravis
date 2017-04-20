/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import Utils.Mailer;
import exercise.fakedatabase.UserFacadeFake;
import exercise.realdatabase.UserFacadeRealDB;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author yoyo
 */
public class AuthenticatorTestIT extends  AuthenticatorTest{
    
        @Override
 public Authenticator makeAuthenticator()
 {
     Mailer mailer = mock(Mailer.class);
   //  return new Authenticator(new UserFacadeFake(), mailer);
     
   
    if (System.getenv("TRAVIS") != null) {
      return new Authenticator(new UserFacadeRealDB("pu_mySql_travis_Integration"), mailer);
    }
    
    return new Authenticator(new UserFacadeRealDB("pu_localDB"), mailer);

     
     
  }
    
    
}
