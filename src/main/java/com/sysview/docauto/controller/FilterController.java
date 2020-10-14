/*package com.sysview.docauto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.model.Filter;
import com.sysview.docauto.service.FilterService;

@RestController
@RequestMapping("/Docauto/filterBy")
public class FilterController {

  @Autowired
  private FilterService filterService;

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseEntity<List<Filter>> filterBy(@RequestBody Filter filter) {
    List<Filter> filters = filterService.filterBy(filter);
    return new ResponseEntity(filters, HttpStatus.OK);
  }
}
*/