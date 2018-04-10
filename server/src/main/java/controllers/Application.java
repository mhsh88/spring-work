//package controllers;
//
//import be.objectify.deadbolt.java.actions.Group;
//import be.objectify.deadbolt.java.actions.Restrict;
//import com.payAm.core.ebean.BaseController;
//import daos.users.UserDao;
//import play.mvc.Result;
//import views.html.index;
//
//import javax.inject.Inject;
//import java.util.Random;
//
//public class Application extends BaseController {
//
//    @Inject UserDao userDao;
//    /*@Inject Environment environment;
//    @Inject Configuration configuration;
//    @Inject MessagesApi messagesApi;*/
//
//    //region Index Actions
//    public Result index() {
//        return ok(index.render());
//    }
//
//    @Restrict(@Group("someRole"))
//    public Result someSecureAction() {
//        return ok();
//    }
//    //endregion
//}
