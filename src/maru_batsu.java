import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class maru_batsu extends Application {

	final Canvas canvas = new Canvas(320, 320);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	int i = 0;
	int XDigit;
	int YDigit;
	int Stack[][] = new int[3][3];
	int type[][] = new int[3][3];
	Label result = new Label("結果がここに表示されます");

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

		BorderPane border = new BorderPane();

		border.setOnMouseClicked(event -> Drawimg(event, i, stage));

		border.setCenter(canvas);
		VBox root = new VBox();
		root.setSpacing(10);
		root.getChildren().addAll(border, result);

		stage.setScene(new Scene(root));
		stage.show();

	}

	void Drawimg(MouseEvent event, int count, Stage stage) {
		int X = (int) (event.getSceneX() / 100) * 100; //座標指定X
		int Y = (int) (event.getSceneY() / 100) * 100; //座標指定Y
		XDigit = X / 100;
		YDigit = Y / 100;

		if (Stack[XDigit][YDigit] == 1) {

			i--;
		} else if (count % 2 == 0) {

			Image imgm = new Image(Paths.get("image/mark_maru_s.png").toUri().toString());
			gc.drawImage(imgm, X, Y);
			type[XDigit][YDigit] = 8;
		} else if (count % 2 == 1) {

			Image imgb = new Image(Paths.get("image/mark_batsu_s.png").toUri().toString());
			gc.drawImage(imgb, X, Y);
			type[XDigit][YDigit] = 9;
		}

		Stack[XDigit][YDigit] = 1;

		i++;

			result(stage);
	}

	void result(Stage stage) {
		// TODO 自動生成されたメソッド・スタブ

		for (int j = 0, k = 0; j < 3; j++) {

			if ((type[j][k] == 8) && (type[j][k + 1] == 8) && (type[j][k + 2] == 8)) {
				result.setText("マルの勝ち");
			} else if ((type[j][k] == 9) && (type[j][k + 1] == 9) && (type[j][k + 2] == 9)) {
				result.setText("バツの勝ち");
			}
		}

		for (int j = 0, k = 0; k < 3; k++) {

			if ((type[j][k] == 8) && (type[j + 1][k] == 8) && (type[j + 2][k] == 8)) {
				result.setText("マルの勝ち");
			} else if ((type[j][k] == 9) && (type[j + 1][k] == 9) && (type[j + 2][k] == 9)) {
				result.setText("バツの勝ち");
			}
		}

		if ((type[0][0] == 8) && (type[1][1] == 8) && (type[2][2] == 8)) {
			result.setText("マルの勝ち");
		} else if ((type[0][0] == 9) && (type[1][1] == 9) && (type[2][2] == 9)) {
			result.setText("バツの勝ち");
		}

		if ((type[0][2] == 8) && (type[1][1] == 8) && (type[2][0] == 8)) {
			result.setText("マルの勝ち");
		} else if ((type[0][2] == 9) && (type[1][1] == 9) && (type[2][0] == 9)) {
			result.setText("バツの勝ち");
		}

	}

}
