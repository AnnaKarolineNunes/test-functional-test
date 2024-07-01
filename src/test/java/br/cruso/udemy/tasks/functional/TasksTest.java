package br.cruso.udemy.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	
	/*
	@Test
	public void deveSalvarTarefaComSucesso() {
		
		WebDriver driver = acessarAplicacao();
		try {
			//clicar em ADD todo
			driver.findElement(By.id("addTodo")).click();
			
			//escrever a descrição
			driver.findElement(By.id("task")).sendKeys("Teste1");
			
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("02/07/2030");

			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();

			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", message);
		} finally{
			//fechar o browser
			driver.quit();
		} 
	}
	*/
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		
		WebDriver driver = acessarAplicacao();
		
		try {
			//clicar em ADD todo
			driver.findElement(By.id("addTodo")).click();
			
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("03/07/2024");

			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();

			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
		} finally {
			//fechar o browser
			driver.quit();
			
		} 
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		
		WebDriver driver = acessarAplicacao();
		
		try {
			//clicar em ADD todo
			driver.findElement(By.id("addTodo")).click();

			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();

			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", message);
		} finally {
			//fechar o browser
			driver.quit();
			
		} 
	}
	
	@Test
	public void deveSalvarTarefaComDataPassada() {
		
		WebDriver driver = acessarAplicacao();
		
		try {
			//clicar em ADD todo
			driver.findElement(By.id("addTodo")).click();
			
			//escrever a descrição
			driver.findElement(By.id("task")).sendKeys("Teste3");
			
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("02/07/2009");

			//clicar em salvar
			driver.findElement(By.id("saveButton")).click();

			//validar mensagem de sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);
		} finally {
			//fechar o browser
			driver.quit();
		} 
	}
}
