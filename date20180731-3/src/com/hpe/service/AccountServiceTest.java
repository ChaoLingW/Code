/**
 * 
 */
package com.hpe.service;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @Description:TODO
 * @author chaoling
 * @date 2018年8月1日
 */

public class AccountServiceTest {

	/**
	 * Test method for {@link com.hpe.service.AccountService#transfer(int, int, int)}.
	 */
	AccountService accountService = new AccountService();
	@Test
	public void testTransfer() {
		
		accountService.transfer(1, 2, 10);
		
		
	}

}
