package com.example.demo.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.manager.ChannelManager;
import com.example.demo.model.Channel;

@Service
public class ChannelManagerImpl implements ChannelManager{

	@Override
	public List<Channel> getAllChannels() {
		
		List<Channel> lstChannel = new ArrayList<>();
		Channel c1 = new Channel();
		c1.setId(1);
		c1.setChannelName("HBO");
		
		lstChannel.add(c1);
		return lstChannel;
	}

	
}
