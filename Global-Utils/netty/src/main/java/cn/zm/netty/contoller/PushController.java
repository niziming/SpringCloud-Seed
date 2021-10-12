package cn.zm.netty.contoller;

import cn.zm.common.config.ResponseResult;
import cn.zm.common.enums.ResultEnum;
import cn.zm.netty.entity.WebSocketEntity;
import cn.zm.netty.handler.NettyHandler;
import cn.zm.netty.service.PushService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/netty")
@Api(tags = "netty测试")
@Slf4j
public class PushController {
    @Resource
    private PushService pushService;

    /**
     * 推送给所有用户
     * @param msg
     */
    @PostMapping("/pushAll")
    public ResponseResult pushToAll(@RequestParam("msg") String msg){
        pushService.pushMsgToAll(msg);
        return ResponseResult.succ("发送成功-" + msg);
    }

    /**
     * 推送给所有用户
     */
    @ApiOperation("枚举测试")
    @PostMapping("/enum")
    public ResponseResult testEnum(String entity){
        JSONObject jsonObject = JSONObject.parseObject(entity);
        WebSocketEntity webSocketEntity = jsonObject.toJavaObject(WebSocketEntity.class);
        System.out.println("webSocketEntity = " + webSocketEntity);
        // String enums = "DATA_EXCEPTION";
        // ResultEnum resultEnum = JSONObject.parseObject(enums).toJavaObject(ResultEnum.class);
        // System.out.println("resultEnum = " + resultEnum);
        return ResponseResult.succ(ResultEnum.DATA_EXCEPTION);
    }
    /**
     * 推送给指定用户
     * @param userId
     * @param msg
     */
    @PostMapping("/pushOne")
    public ResponseResult pushMsgToOne(@RequestParam("userId") String userId,@RequestParam("msg") String msg){
        pushService.pushMsgToOne(userId,msg);
        return ResponseResult.succ("发送成功-id: " + userId + "-msg: " + msg);
    }

    /**
     * 推送给指定用户
     */
    @PostMapping("/clean")
    public ResponseResult clean(){
        NettyHandler.getUserChannelMap().clear();
        return ResponseResult.succ("清理成功");
    }

}
