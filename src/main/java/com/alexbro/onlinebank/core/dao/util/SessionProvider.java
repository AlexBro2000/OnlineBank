package com.alexbro.onlinebank.core.dao.util;

import org.hibernate.Session;

public interface SessionProvider {

    Session getSession();
}
