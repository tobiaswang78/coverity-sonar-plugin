package org.sonar.plugins.coverity.server;

import org.sonar.api.Extension;
import org.sonar.api.resources.AbstractLanguage;

/**
 * Fix Bug 71347. When adding a new profile Sonarqube's server checks if the language of that profile is on a list of
 * accepted languages. If not, it will not store rules for that profile, but it will try to create a profile anyway,
 * resulting on a null pointer exception when trying to access the rules for that profile. This can cause the server to
 * crash at star up.
 * This class defines a language that will be added to that list of accepted languages.
 */
public class CxxLanguage extends AbstractLanguage implements Extension {
    public static final CxxLanguage INSTANCE = new CxxLanguage();

    /**
     * CxxLanguage key
     */
    public static final String KEY = "c++";

    /**
     * CxxLanguage name
     */
    public static final String NAME = "c++";

    /**
     * Default package name for classes without package def
     */
    public static final String DEFAULT_PACKAGE_NAME = "[default]";

    /**
     * C++ files knows suffixes
     */
    public static final String[] SUFFIXES = {".cpp", ".cc", ".c++", ".cp", ".cxx"};

    /**
     * Default constructor
     */
    public CxxLanguage() {
        super(KEY, NAME);
    }

    @Override
    public String[] getFileSuffixes() {
        return SUFFIXES;
    }
}
