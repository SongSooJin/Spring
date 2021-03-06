package com.example.demo.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.dto.ServerResponse;

@RestController
// 여기서 @RequestMapping("/emps")를 작성하면 클래스 별 적용이 된다.
@RequestMapping("/emps")
public class EmployeeRestController {
	private List<Employee> employees = new ArrayList<Employee>();
	
	@PostConstruct
	public void init() {
		employees.add(new Employee(1, "Adam", "Sandler"));
		employees.add(new Employee(2, "Bob", "Ross"));
		employees.add(new Employee(3, "Chris", "Evans"));
	}
	
	@RequestMapping(method=RequestMethod.GET)
//	@GetMapping = @RequestMapping(method=RequestMethod.GET) 같은 표현식
//	@GetMapping
	public Object get() {
		// employees ==> ServerResponse ==> message
		ServerResponse message = new ServerResponse(employees);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "json", Charset.forName("UTF-8")));
		return new ResponseEntity<ServerResponse>(message, headers, HttpStatus.OK);
	}
	
//	@RequestMapping("/emps") <== 클래스에 부여된 설정
	@RequestMapping(method=RequestMethod.POST)
//	@PostMapping
	public Object post(@RequestBody Employee employee) {
		if (employees.size() > 0) {
			Comparator<Employee> comp = (e1, e2) -> Integer
					.compare(e1.getId(), e2.getId());
			
			Employee emp = employees.stream().max(comp).get();
			
			employee.setId(emp.getId() + 1);
		} else {
			employee.setId(1);
		}
		employees.add(employee);
		ServerResponse message = new ServerResponse(employee);
		// OK : 상태 코드이며 외울수 없으니 상황에 맞게 보고 사용해라. 
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}
	
//	@RequestMapping("/emps") <== 클래스에 부여된 설정
	@DeleteMapping("/{id}")
//	사용되는 URL 패턴 == "/emps/{id}"
	public Object delete(@PathVariable int id) {
		Employee emp = employees.stream()
				.filter((e) -> e.getId() == id)
				.findAny().orElse(null);
		if (emp != null) {
			employees.remove(emp);
		}
		
//		return new ResponseEntity<>(HttpStatus.OK);
		
		ServerResponse message = new ServerResponse();
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
		
	}
	
//	@RequestMapping("/emps") <== 클래스에 부여된 설정
	@PutMapping("/{id}")
	public Object update(@PathVariable int id,
			@RequestBody Employee employee) {
		
		Employee emp = employees.stream()
				.filter((e) -> e.getId() == id)
				.findAny().orElse(null);
		if (emp != null) {
			employees.set(employees.indexOf(emp), employee);
		}
		ServerResponse message = new ServerResponse(employee);
		return new ResponseEntity<ServerResponse>(message, HttpStatus.OK);
	}
}
