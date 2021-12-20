package guillermo.lagos.composables.shared.screen.signature

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class SignatureView : View {

    var mPathPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG) // line

    lateinit var canvas: Canvas // background

    private lateinit var mPath: Path // line drawing

    private var mPreX: Float = 0.0f // x coordinate

    private var mPreY: Float = 0.0f // y coordinate

    private val touchTolerance:Float = 4F // diff between two points

    var isSignatureDrawn = false
        private set

    init {
        mPathPaint.isAntiAlias = true
        mPathPaint.isDither = true
        mPathPaint.style = Paint.Style.STROKE
        mPathPaint.strokeJoin = Paint.Join.ROUND
        mPathPaint.strokeCap = Paint.Cap.ROUND
        mPathPaint.strokeWidth = 2f
        mPathPaint.color = Color.BLACK
    }

    constructor(
        context: Context
    ) : super(
        context
    )

    constructor(
        context: Context,
        attrs: AttributeSet
    ) : super(context, attrs)

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int
    ) : super(
        context,
        attrs,
        defStyleAttr
    )

    @SuppressLint("NewApi")
    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    @SuppressLint("DrawAllocation")
    override fun onMeasure(
        widthMeasureSpec: Int,
        heightMeasureSpec: Int
    ) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mPath = Path()
        canvas = Canvas()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(
        event: MotionEvent?
    ): Boolean {

        when(event?.action){

            MotionEvent.ACTION_DOWN-> {

                isSignatureDrawn = true
                mPreX = event.x
                mPreY = event.y
                mPath.moveTo(mPreX, mPreY)

            }

            MotionEvent.ACTION_MOVE-> {

                val x = event.x
                val y = event.y
                val dx = kotlin.math.abs(mPreX - x)
                val dy = kotlin.math.abs(mPreY - y)

                if(
                    dx >= touchTolerance
                    ||
                    dy >= touchTolerance
                ){
                    mPath.quadTo(mPreX,mPreY,(x+mPreX)/2,(y+mPreY)/2)
                    mPreX = event.x
                    mPreY = event.y
                }

            }

            MotionEvent.ACTION_UP->{

                mPath.lineTo(event.x,event.y)
                canvas.drawPath(mPath,mPathPaint)

            }

        }

        invalidate()

        return true
    }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)
        canvas?.drawPath(mPath,mPathPaint)

    }

    fun clearSignature(){

        mPath = Path()
        canvas = Canvas()
        isSignatureDrawn = false
        invalidate()

    }

    val signature: Bitmap
        get() {

        val bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        if(background != null) background.draw(canvas)
        else{
            canvas.drawColor(Color.WHITE)
            draw(canvas)
        }

        return bitmap

    }
}