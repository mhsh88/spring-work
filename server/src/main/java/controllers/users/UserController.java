//package controllers.users;
//
//import be.objectify.deadbolt.java.actions.SubjectPresent;
//import com.avaje.ebean.annotation.Transactional;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.feth.play.module.pa.PlayAuthenticate;
//import com.feth.play.module.pa.user.AuthUser;
//import com.payAm.core.ebean.BaseDao;
//import com.payAm.core.ebean.RestController;
//import daos.users.UserDao;
//import dtos.siteMap.SiteMapItemDto;
//import dtos.users.UserView;
//import models.users.UserEntity;
//import play.libs.Json;
//import play.mvc.Result;
//
//import javax.inject.Inject;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * Developer: Payam Mostafaei
// * Creation Time: 2017/Jun/03 - 11:25
// */
//public class UserController extends
//        RestController<UserEntity, Long, UserView> {
//
//    @Inject
//    private UserDao dao;
//    @Inject
//    private PlayAuthenticate auth;
//
//    @Override
//    public BaseDao<Long, UserEntity> getDao() {
//        return dao;
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.USER_UPDATE)
//    public Result insert() {
//        return super.insert();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.USER_UPDATE)
//    public Result update() {
//        return super.update();
//    }
//
//    @Override
//    @Transactional
//    //@Pattern(Permission.USER_DELETE)
//    public Result delete(Long id) {
//        return super.delete(id);
//    }
//
//    @Transactional
//    public UserEntity getCurrentUser() {
//        final AuthUser currentAuthUser = this.auth.getUser(session());
//        return dao.findByAuthUserIdentity(currentAuthUser);
//    }
//
//    @Transactional
//    public List<SiteMapItemDto> getCurrentUserSiteMap() {
//        UserEntity user = getCurrentUser();
//        List<String> permissions = user.getPermissions()
//                .parallelStream()
//                .map(be.objectify.deadbolt.java.models.Permission::getValue)
//                .collect(Collectors.toList());
//        List<SiteMapItemDto> userSiteMap = new ArrayList<>();
//        try {
//            File siteMap = getEnvironment().getFile("/panelSiteMap.json");
//            ObjectMapper mapper = new ObjectMapper();
//            List<SiteMapItemDto> siteMapList = mapper.readValue(siteMap, new TypeReference<List<SiteMapItemDto>>() { });
//            for (SiteMapItemDto siteMapDto: siteMapList) {
//                SiteMapItemDto firstLevelNode = new SiteMapItemDto();
//                firstLevelNode.setTitle(siteMapDto.getTitle());
//                firstLevelNode.setIcon(siteMapDto.getIcon());
//                for (SiteMapItemDto node: siteMapDto.getChildren())
//                    if (permissions.contains(node.getPermission())) {
//                        SiteMapItemDto secondLevelNode = new SiteMapItemDto();
//                        secondLevelNode.setTitle(getMessages().at(node.getTitle()));
//                        secondLevelNode.setPermission(node.getPermission());
//                        secondLevelNode.setIcon(node.getIcon());
//                        secondLevelNode.setMainView(node.getMainView());
//                        firstLevelNode.addChild(secondLevelNode);
//                    }
//                if (firstLevelNode.getChildren().size() > 0)
//                    userSiteMap.add(firstLevelNode);
//            }
//        }
//        catch (IOException e) {
//
//        }
//        return userSiteMap;
//    }
//
//    @SubjectPresent
//    public Result userSiteMap() {
//        return ok(Json.toJson(getCurrentUserSiteMap()));
//    }
//}