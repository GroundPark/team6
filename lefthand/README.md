
.classpath 폴더 및 파일

자기만의 경로로 설정해야 함에 주의하세요. 포폴 파일 통으로 받아서 적용해도 자기 경로로해야 적용됩니다


<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8">
		<attributes>
			<attribute name="owner.project.facets" value="java"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.web.container"/>
	<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.module.container"/>
	
	
	<classpathentry kind="lib" path="F:/pjs/web/apache/lib/jsp-api.jar"/>			<<--- 이부분!!!
	<classpathentry kind="lib" path="F:/pjs/web/apache/lib/servlet-api.jar"/>		<<--- 이부분!!!
	
	
	<classpathentry kind="output" path="build/classes"/>
</classpath>
