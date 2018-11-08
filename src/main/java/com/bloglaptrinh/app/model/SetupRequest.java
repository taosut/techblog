package com.bloglaptrinh.app.model;


import com.bloglaptrinh.app.domain.PersonalName;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class SetupRequest implements Serializable {
	
	private String websiteTitle;
	private String defaultLanguage;
	private List<String> languages;
	private String mediaUrlPrefix;
	private String mediaPath;
//	private String mailSmtpHost;
//	private String mailFrom;
	private String loginId;
	private String loginPassword;
	private PersonalName name;
	private String email;

	public String getWebsiteTitle() {
		return websiteTitle;
	}

	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public String getMediaUrlPrefix() {
		return mediaUrlPrefix;
	}

	public String getMediaPath() {
		return mediaPath;
	}

//	public String getMailSmtpHost() {
//		return mailSmtpHost;
//	}
//
//	public String getMailFrom() {
//		return mailFrom;
//	}

	public String getLoginId() {
		return loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public PersonalName getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public static class Builder  {

		private String websiteTitle;
		private String defaultLanguage;
		private List<String> languages;
//		private String mediaUrlPrefix;
//		private String mediaPath;
//		private String mailSmtpHost;
//		private String mailFrom;
		private String loginId;
		private String loginPassword;
		private PersonalName name;
		private String email;

		public Builder() {
		}

		public Builder websiteTitle(String websiteTitle) {
			this.websiteTitle = websiteTitle;
			return this;
		}

		public Builder defaultLanguage(String defaultLanguage) {
			this.defaultLanguage = defaultLanguage;
			return this;
		}

		public Builder languages(List<String> languages) {
			this.languages = languages;
			return this;
		}

//		public Builder mediaUrlPrefix(String mediaUrlPrefix) {
//			this.mediaUrlPrefix = mediaUrlPrefix;
//			return this;
//		}
//
//		public Builder mediaPath(String mediaPath) {
//			this.mediaPath = mediaPath;
//			return this;
//		}

//		public Builder mailSmtpHost(String mailSmtpHost) {
//			this.mailSmtpHost = mailSmtpHost;
//			return this;
//		}
//
//		public Builder mailFrom(String mailFrom) {
//			this.mailFrom = mailFrom;
//			return this;
//		}

		public Builder loginId(String loginId) {
			this.loginId = loginId;
			return this;
		}

		public Builder loginPassword(String loginPassword) {
			this.loginPassword = loginPassword;
			return this;
		}

		public Builder name(PersonalName name) {
			this.name = name;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public SetupRequest build() {
			SetupRequest request = new SetupRequest();
			request.websiteTitle = websiteTitle;
			request.defaultLanguage = defaultLanguage;
			request.languages = languages;
//			request.mediaUrlPrefix = mediaUrlPrefix;
//			request.mediaPath = mediaPath;
//			request.mailSmtpHost = mailSmtpHost;
//			request.mailFrom = mailFrom;
			request.loginId = loginId;
			request.loginPassword = loginPassword;
			request.name = name;
			request.email = email;
			return request;
		}
	}
}
