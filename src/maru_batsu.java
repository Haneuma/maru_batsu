import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class maru_batsu extends Application {

	final Canvas canvas = new Canvas(300, 400);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	int i = 0;
	int[] XStack = new int[19];
	int[] YStack = new int[19];
	boolean resault;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		stage.setWidth(320);
		stage.setHeight(400);
		stage.setTitle("○×ゲーム");

		BorderPane root = new BorderPane();

		root.setOnMouseClicked(event -> Drawimg(event, i++));

		root.setCenter(canvas);

		stage.setScene(new Scene(root));
		stage.show();

	}

	void Drawimg(MouseEvent event, int count) {
		int X = (int) (event.getSceneX() / 100) * 100; //座標指定X
		int Y = (int) (event.getSceneY() / 100) * 100; //座標指定Y

		if (count % 2 == 0) {

			Image img = new Image(Paths.get("image/mark_maru_s.png").toUri().toString());
			gc.drawImage(img, X, Y);

		} else if (count % 2 == 1) {

			Image img = new Image(Paths.get("image/mark_batsu_s.png").toUri().toString());
			gc.drawImage(img, X, Y);

		}

	}

}
