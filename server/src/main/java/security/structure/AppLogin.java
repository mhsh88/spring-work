//package security.structure;
//
//import com.feth.play.module.pa.providers.password.UsernamePasswordAuthProvider;
//import play.data.validation.Constraints.*;
//
///**
// * Created by Payam Mostafaei
// * Creation Time: 2017/Feb/06 - 09:30 PM
// */
//public class AppLogin extends AppIdentity implements UsernamePasswordAuthProvider.UsernamePassword {
//
//    @Required
//    @MinLength(6)
//    public String password;
//
//    @Override
//    public String getEmail() {
//        return username;
//    }
//
//    public String getPhoneNumber() {
//        return username;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//}
