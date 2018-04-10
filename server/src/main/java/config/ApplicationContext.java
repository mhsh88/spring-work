//package config;
//
//import com.feth.play.module.mail.IMailer;
//import com.feth.play.module.mail.Mailer;
//import com.feth.play.module.pa.Resolver;
//import com.feth.play.module.pa.providers.oauth2.google.GoogleAuthProvider;
//import com.google.inject.AbstractModule;
//import com.google.inject.assistedinject.FactoryModuleBuilder;
//import play.i18n.MessagesApi;
//import security.provider.AppUsernamePasswordAuthProvider;
//import security.resolver.SecurityResolver;
//import services.SecurityService;
//
///**
// * Created by Payam Mostafaei
// * Creation Time: 2017/Jan/08 - 08:25 PM
// */
//public class ApplicationContext extends AbstractModule {
//
//    @Override
//    protected void configure() {
//        install(new FactoryModuleBuilder().implement(IMailer.class, Mailer.class).build(Mailer.MailerFactory.class));
//
//        bind(Resolver.class).to(SecurityResolver.class);
//
//        bind(SecurityService.class).asEagerSingleton();
//        bind(GoogleAuthProvider.class).asEagerSingleton();
//        //bind(FacebookAuthProvider.class).asEagerSingleton();
//        //bind(TwitterAuthProvider.class).asEagerSingleton();
//        //bind(LinkedinAuthProvider.class).asEagerSingleton();
//        bind(AppUsernamePasswordAuthProvider.class).asEagerSingleton();
//
//        //bind(Application.class).asEagerSingleton();
//        bind(MessagesApi.class).asEagerSingleton();
//    }
//}