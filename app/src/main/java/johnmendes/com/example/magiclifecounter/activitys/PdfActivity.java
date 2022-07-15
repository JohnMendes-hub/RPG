package johnmendes.com.example.magiclifecounter.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

import johnmendes.com.example.magiclifecounter.R;

public class PdfActivity extends AppCompatActivity {

    private PDFView pdfView;

    private void initViews() {
        pdfView = (PDFView) findViewById(R.id.pdfView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        initViews();
        setPdfView();
    }

    public void setPdfView() {
        pdfView.fromAsset("Monsters.pdf")
                //.pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .enableAntialiasing(true)
                .onDraw(new OnDrawListener() {
                    @Override
                    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                        //                        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888); //low res
                        //
                        //                        Paint paint = new Paint();
                        //                        paint.setColor(Color.BLUE);
                        //                        canvas.drawBitmap(bitmap, 0,0, paint);
                    }
                })
                // allows to draw something on the current page, usually visible in the middle of the screen
                //.onDraw(onDrawListener)
                // allows to draw something on all pages, separately for every page. Called only for visible pages
                //.onDrawAll(onDrawListener)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        //Toast.makeText(HomeActivity.this, "Complete", Toast.LENGTH_SHORT).show();
                        Log.d("TAG", "Complete");
                    }
                }) // called after document is loaded and starts to be rendered
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        Log.d("TAG", "Complete");
                    }
                })
                .onPageScroll(new OnPageScrollListener() {
                    @Override
                    public void onPageScrolled(int page, float positionOffset) {
                        Log.d("TAG", "onPageScrolled");
                    }
                })
                .onError(new OnErrorListener() {
                    @Override
                    public void onError(Throwable t) {
                        Log.d("TAG", "onError");
                    }
                })
                .onPageError(new OnPageErrorListener() {
                    @Override
                    public void onPageError(int page, Throwable t) {
                        Log.d("TAG", "onPageError");
                    }
                })
                .onRender(new OnRenderListener() {
                    @Override
                    public void onInitiallyRendered(int nbPages) {
                        Log.d("TAG", "OnRenderListener");
                    }
                }) // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                .onTap(new OnTapListener() {
                    @Override
                    public boolean onTap(MotionEvent e) {
                        return false;
                    }
                })
                .enableAnnotationRendering(true) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                //.autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                //.linkHandler(DefaultLinkHandler)
                //.pageFitPolicy(FitPolicy.WIDTH)
                // .pageSnap(true) // snap pages to screen boundaries
                // .pageFling(false) // make a fling change only a single page like ViewPager
                .load();
    }
}