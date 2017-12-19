package com.book.mybatis;

import com.book.mybatis.properties.Initproperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {
@Autowired
private Initproperties initproperties;
	@Test
	public void contextLoads() {
		System.out.println(initproperties.getAddress()+"65416--0"+initproperties.getDbName());
	}

}
