package com.spring.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MongoOperations {

	@Autowired
	MongoTemplate mongoTemplate;

	@RequestMapping(value = "/addStudent", method = RequestMethod.PUT)
	@ResponseBody
	String insert(@RequestBody Student student) {
		mongoTemplate.insert(student);
		return "success";
	}

	@RequestMapping(value = "/getStudent/{name}", method = RequestMethod.GET)
	@ResponseBody
	Student retrieve(@PathVariable("name") String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		Student student = mongoTemplate.findOne(query, Student.class);
		return student;
	}

	@RequestMapping(value = "/deltStudent/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	String delete(@PathVariable("name") String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		mongoTemplate.remove(query, Student.class);
		return "Delete success";
	}

	@RequestMapping(value = "/updtStudent/{name}", method = RequestMethod.POST)
	@ResponseBody
	String updateDept(@PathVariable("name") String name,
			@RequestBody String newDept) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		Update update = new Update();
		update.set("department", newDept);
		mongoTemplate.updateFirst(query, update, Student.class);
		return "Update success";
	}
}
