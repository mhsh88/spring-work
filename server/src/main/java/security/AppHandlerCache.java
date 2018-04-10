//package security;
//
//import be.objectify.deadbolt.java.DeadboltHandler;
//import be.objectify.deadbolt.java.ExecutionContextProvider;
//import be.objectify.deadbolt.java.cache.HandlerCache;
//import com.feth.play.module.pa.PlayAuthenticate;
//
//import javax.inject.Inject;
//import javax.inject.Singleton;
//
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2015/Sep/21 - 10:55 PM
// */
//@Singleton
//public class AppHandlerCache implements HandlerCache {
//
//	private final DeadboltHandler defaultHandler;
//	private final PlayAuthenticate auth;
//
//	@Inject
//	public AppHandlerCache(final PlayAuthenticate auth, final ExecutionContextProvider execContextProvider) {
//		this.auth = auth;
//		this.defaultHandler = new AppDeadboltHandler(auth, execContextProvider);
//	}
//
//	@Override
//	public DeadboltHandler apply(final String key) {
//		return this.defaultHandler;
//	}
//
//	@Override
//	public DeadboltHandler get() {
//		return this.defaultHandler;
//	}
//}