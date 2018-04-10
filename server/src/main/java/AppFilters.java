//package app;
//
//import play.filters.cors.CORSFilter;
//import play.http.HttpFilters;
//import play.mvc.EssentialFilter;
//
//import javax.inject.Inject;
//
///**
// * Created by Payam Mostafaei
// * Creation time: 2017/Aug/26 - 11:10 AM
// */
//public class AppFilters implements HttpFilters {
//
//    @Inject
//    private CORSFilter corsFilter;
//
//    /*@Inject
//    public Filters(GzipFilter gzipFilter, CORSFilter corsFilter, IntrusionDetectorFilter intrusionDetectorFilter,
//                   AllowedHostsFilter allowedHostsFilter, SecurityHeadersFilter securityHeadersFilter) {
//
//        super(gzipFilter, corsFilter, allowedHostsFilter, securityHeadersFilter, intrusionDetectorFilter);
//        this.corsFilter = corsFilter;
//    }*/
//
//    public EssentialFilter[] filters() {
//        return new EssentialFilter[] { corsFilter.asJava() };
//    }
//}
