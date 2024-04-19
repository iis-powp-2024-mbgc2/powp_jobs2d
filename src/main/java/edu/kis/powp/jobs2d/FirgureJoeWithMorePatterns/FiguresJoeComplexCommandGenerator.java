package edu.kis.powp.jobs2d.FirgureJoeWithMorePatterns;
import java.util.ArrayList;
import java.util.List;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class FiguresJoeComplexCommandGenerator {
	private final List<FiguresJoeFigureGenerator> figureGenerators;
	private final List<FiguresJoeComplexCommandObserver> observers;

	public FiguresJoeComplexCommandGenerator() {
		figureGenerators = new ArrayList<>();
		observers = new ArrayList<>();
	}
	public void addFigureGenerator(FiguresJoeFigureGenerator figureGenerator) {
		figureGenerators.add(figureGenerator);
	}

	public void addComplexCommandObserver(FiguresJoeComplexCommandObserver observer) {
		observers.add(observer);
	}

	public void executeAllFigures(Job2dDriver driver) {
		for (FiguresJoeFigureGenerator figureGenerator : figureGenerators) {
			figureGenerator.generate(driver);
		}
		notifyObservers();
	}

	private void notifyObservers() {
		for (FiguresJoeComplexCommandObserver observer : observers) {
			observer.onCommandExecuted();
		}
	}
	public static class CompositeFigureGenerator implements FiguresJoeFigureGenerator {
		private List<FiguresJoeFigureGenerator> generators;

		public CompositeFigureGenerator() {
			generators = new ArrayList<>();
		}

		public void addFigureGenerator(FiguresJoeFigureGenerator generator) {
			generators.add(generator);
		}

		@Override
		public void generate(Job2dDriver driver) {
			for (FiguresJoeFigureGenerator generator : generators) {
				generator.generate(driver);
			}
		}
	}
	public static class FigureGeneratorFacade {
		private FiguresJoeComplexCommandGenerator complexCommandGenerator;

		public FigureGeneratorFacade() {
			complexCommandGenerator = new FiguresJoeComplexCommandGenerator();
		}

		public void addFigureGenerator(FiguresJoeFigureGenerator generator) {
			complexCommandGenerator.addFigureGenerator(generator);
		}

		public void executeAllFigures(Job2dDriver driver) {
			complexCommandGenerator.executeAllFigures(driver);
		}
	}

	public static class FigureGeneratorAdapter implements FiguresJoeFigureGenerator {
		private FiguresJoe figuresJoe;

		public FigureGeneratorAdapter(FiguresJoe figuresJoe) {
			this.figuresJoe = figuresJoe;
		}

		@Override
		public void generate(Job2dDriver driver) {
			FiguresJoe.figureScript1(driver);
			FiguresJoe.figureScript2(driver);
		}
	}
	public static class LoggingDecorator implements FiguresJoeComplexCommandObserver {
		private FiguresJoeComplexCommandObserver observer;

		public LoggingDecorator(FiguresJoeComplexCommandObserver observer) {
			this.observer = observer;
		}

		@Override
		public void onCommandExecuted() {
			System.out.println("Completed");
			observer.onCommandExecuted();
		}
	}

	public interface FiguresJoeComplexCommandObserver {
		void onCommandExecuted();
	}

	public interface FiguresJoeFigureGenerator {
		void generate(Job2dDriver driver);
	}
	public static class FiguresJoeFigureGeneratorIterator {
		private List<FiguresJoeFigureGenerator> generators;
		private int position;

		public FiguresJoeFigureGeneratorIterator(List<FiguresJoeFigureGenerator> generators) {
			this.generators = generators;
			this.position = 0;
		}

		public boolean hasNext() {
			return position < generators.size();
		}

		public FiguresJoeFigureGenerator next() {
			return generators.get(position++);
		}
	}
}

