import com.wizneylabs.leetcoding.GridRenderer

class GridRendererTests {
    fun testGridRenderer() {

        val renderer = GridRenderer(15, 15);

        for (i in 1..15 - 2) {

            renderer.setCellColor(1, i, GridRenderer.BG_WHITE);
        }

        for (i in 2..15 - 2) {

            renderer.setCellColor(i, 13, GridRenderer.BG_WHITE);
        }

        renderer.setCellColor(0, 0, GridRenderer.BG_WHITE);
        renderer.setCellColor(0, 1, GridRenderer.BG_WHITE);
        renderer.setCellColor(1, 0, GridRenderer.BG_WHITE);

        renderer.setCellColor(13, 14, GridRenderer.BG_WHITE);
        renderer.setCellColor(14, 14, GridRenderer.BG_WHITE);
        renderer.setCellColor(14, 13, GridRenderer.BG_WHITE);

        renderer.draw();
    }
}