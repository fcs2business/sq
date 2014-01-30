package br.com.bestsmart.smartquote.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.bestsmart.smartquote.business.test.UsuarioBsTest;
import br.com.bestsmart.smartquote.business.test.WorkspaceBsTest;
import br.com.bestsmart.smartquote.view.test.UsuarioCtrlTest;
import br.com.bestsmart.smartquote.view.test.WorkspaceCtrlTest;

@RunWith(Suite.class)
@SuiteClasses({
		WorkspaceBsTest.class,
		UsuarioBsTest.class,
		WorkspaceCtrlTest.class,
		UsuarioCtrlTest.class
})
public class AllTests {

}
