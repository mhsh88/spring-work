//package controllers.users;
//
//import com.avaje.ebean.annotation.Transactional;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.users.TokenActionDao;
//import dtos.users.TokenActionView;
//import models.users.TokenActionEntity;
//import play.mvc.Result;
//
//import javax.inject.Inject;
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2017/Jun/03 - 11:25
// */
//public class TokenActionController extends
//        RestController<TokenActionEntity, Long, TokenActionView> {
//
//    @Inject
//    private TokenActionDao dao;
//
//    @Override
//    public BaseDao<Long, TokenActionEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.TOKEN_ACTION_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.TOKEN_ACTION_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.TOKEN_ACTION_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//}