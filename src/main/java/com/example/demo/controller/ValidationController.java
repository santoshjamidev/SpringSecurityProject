package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.manager.ChannelManager;
import com.example.demo.model.Channel;

@RestController
@RequestMapping("/base")
public class ValidationController {

	@Autowired
	private ChannelManager manager;
	
	@GetMapping
	@RequestMapping("/channels")
	public List<Channel> getAllChannels(){
		
		return manager.getAllChannels();
	}
	
}
