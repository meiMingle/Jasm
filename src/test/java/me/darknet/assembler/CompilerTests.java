package me.darknet.assembler;

import me.darknet.assembler.exceptions.AssemblerException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CompilerTests {
	@ParameterizedTest
	@MethodSource("paths")
	public void testExample(Path path) throws Exception {
		String name = path.getFileName().toString();
		byte[] bytes = Files.readAllBytes(path);
		String source = new String(bytes);
		System.out.print("Testing: " + name);
		try {
			byte[] test = Assembler.assemble(source, 52, bytes);
			System.out.println(" - OK");
			// write test result to file
			Path out = Paths.get("build/reports/test-classes/" + name.replace(".ja", ".class"));
			Files.createDirectories(out.getParent());
			if(Files.exists(out)) {
				Files.delete(out);
			} else {
				Files.createFile(out);
			}
			Files.write(out, test);
		} catch (AssemblerException e) {
			throw new RuntimeException(e.describe(), e);
		}
	}

	public static List<Path> paths() throws IOException {
		return Files.walk(Paths.get("src/test/resources/"))
				.filter(p -> p.toString().endsWith(".ja"))
				.collect(Collectors.toList());
	}
}
