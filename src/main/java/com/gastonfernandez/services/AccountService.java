package com.gastonfernandez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.gastonfernandez.models.Account;
import com.gastonfernandez.repositories.AccountRepository;

@Service
@Slf4j
public class AccountService {

	@Autowired
	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void setAccount(Account account) throws Exception {
		try {
			log.info("setAccount-Services --> Start");
			log.info("setAccount-Services -->Datos de shopping a actualizar: ");
			log.info(account.toString());
			this.accountRepository.save(account);
			log.info("setAccount-Services -->Datos actualizados");
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public Account getAccount(long accountId) {
		try {
			return accountRepository.findById(accountId).orElse(null);
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	public Object getAccount(String accountDescription) {
		try {
			List<Account> accounts = accountRepository.findByDescription(accountDescription);
			if (accounts.isEmpty()) {
				return null;
			} else if (accounts.size() == 1) {
				return accounts.get(0);
			}
			return accounts;
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

	private Account getAccountByList(Object accounts) {
		Account response = new Account();
		if (accounts instanceof Account)
			response = (Account) accounts;
		else if (accounts instanceof List) {
			List<Account> accountsAux = (List<Account>) accounts;
			response = accountsAux.get(0);
		}
		return response;
	}

	public Account checkAccount(String accountDescription) throws Exception {
		try {
			Object accounts = this.getAccount(accountDescription);
			Account account = new Account();
			if (accounts == null) {
				log.info("checkAccount-Service --> La cuenta " + accountDescription + " no existe");
				log.info("checkAccount-Service --> creando cuenta...");
				account = new Account();
				account.setAccount(accountDescription);
				this.setAccount(account);
				account = this.getAccountByList(this.getAccount(accountDescription));
				log.info("checkAccount-Service --> La cuenta " + accountDescription + " fue creada");
			} else if (accounts instanceof Account) {
				// Si el resultado es una instancia de Account
				account = (Account) accounts;
				log.info("checkAccount-Service --> La cuenta " + account.toString() + " existe");
			} else if (accounts instanceof List) {
				log.error("Las cuentas asociadas a " + accountDescription + " son mas de una (Se asigna la primera): ");
				log.error(accounts.toString());
				account = this.getAccountByList(accounts);
			}
			return account;
		} catch (Exception e) {
			log.error(e.toString());
			throw e;
		}
	}

}
