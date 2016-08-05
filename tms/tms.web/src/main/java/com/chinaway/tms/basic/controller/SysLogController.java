package com.chinaway.tms.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinaway.tms.admin.model.SysLog;
import com.chinaway.tms.admin.service.SysLogService;
import com.chinaway.tms.utils.json.JsonUtil;

@Controller
public class SysLogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysLogController.class);
	
	@Autowired
	private SysLogService sysLogService;

	/**
	 * 添加日志信息<br>
	 * 返回用户的json串
	 * 
	 * @param logInfo
	 * @return
	 */
	@RequestMapping(value = "/ws/addLog")
	@ResponseBody
	// http://localhost/tms/ws/addLog?logInfo=
	public String addLog(@RequestParam("logInfo") String logInfo) {
		LOGGER.info("传入的参数(logInfo):" + logInfo);
		
		SysLog sysLog = JsonUtil.jsonStr2Obj(logInfo, SysLog.class);
		Map<String, String> argsMap = new HashMap<String, String>();
		try {
			sysLogService.insert(sysLog);
			argsMap.put("status", "true");
			argsMap.put("msg", "add Log success!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			argsMap.put("status", "false");
			argsMap.put("msg", "add Log failed!");
		}

		String ret = JsonUtil.obj2JsonStr(argsMap);
		
		LOGGER.info("addUser传出的参数:" + ret);

		return ret;
	}

}