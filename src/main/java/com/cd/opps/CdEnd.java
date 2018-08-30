package com.cd.opps;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cd.rules.ruleBook;


public class CdEnd {

	@Inject
	private ruleBook service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.SeeCollection();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.GotANewCd(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
		return service.ChangeACd(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.LostACd(id);
	}
}
