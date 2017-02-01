package com.example.denischuvasov.viper.ui.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denischuvasov.viper.R;
import com.example.denischuvasov.viper.api.dto.Bidding;
import com.example.denischuvasov.viper.api.dto.Order;


import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderView extends FrameLayout {

    public static final String TEMPLATE_DIRECTION = "%s - %s";
    private static final long MIN_INTERVAL = 60000L;

    @BindView(R.id.order_item)
    protected View orderItemView;

    @BindView(R.id.direction)
    protected TextView directionView;

    @BindView(R.id.auto_type)
    protected TextView autoTypeView;

    @BindView(R.id.sale_status)
    protected TextView saleStatusView;

    @BindView(R.id.price)
    protected TextView priceView;

    @BindView(R.id.favorite_icon)
    protected ImageButton favoriteIconView;

    @BindView(R.id.type)
    protected TextView typeView;

    @BindView(R.id.win_notification_icon)
    protected View winNotificationIcon;

    @BindView(R.id.action_button)
    protected AppCompatButton actionButton;

    @BindView(R.id.left_colored_strip)
    protected View leftColoredStrip;

    @BindView(R.id.clock_image)
    protected ImageView clockImageView;

    private boolean showActionButton;
    private Order order;

    public OrderView(Context context) {
        this(context, null);
    }

    public OrderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
        handleAttributes(attrs);

    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_order, this);
        ButterKnife.bind(this);
    }


    @Override
    public void setOnClickListener(OnClickListener l) {
        orderItemView.setOnClickListener(l);
    }

    public void setOrder(Order order) {
        this.order = order;
        bindOrder();
    }

    private void bindOrder() {
        if (order != null) {
            directionView.setText(String.format(TEMPLATE_DIRECTION,
                    order.getDeparturePoint().getLocalityName(),
                    order.getDestinationPoint().getLocalityName()));
            typeView.setText(getTypeString(order.getBidding().getBiddingTypeId()));
            leftColoredStrip.setBackgroundColor(getColorByStatus());
            saleStatusView.setTextColor(getColorByStatus());
            saleStatusView.setText(getStatusString());
            updateClockImageColor();
            bindTruckType();
            favoriteIconView.setSelected(order.isFavorite());
            //Bind footer
            priceView.setText(order.getCost());
//            actionButton.setSupportBackgroundTintList(ContextCompat.getColorStateList(getContext(), getColorStateList()));
            int actualStatus = order.getBidding().getActualStatus();
            actionButton.setEnabled(actualStatus != Bidding.STATUS_WAITING_START && actualStatus != Bidding.STATUS_ENDED);
            actionButton.setText(getActionButtonNameByStatus());

            boolean win = order.winOrder();
            if(showActionButton) {
                boolean show = win || actualStatus == Bidding.STATUS_ENDED;
                actionButton.setVisibility(show ? GONE : VISIBLE);
            }
            winNotificationIcon.setVisibility(win ? VISIBLE : GONE);
        }
    }

    private void updateClockImageColor() {
        clockImageView.setColorFilter(getColorByStatus(), PorterDuff.Mode.SRC_ATOP);
    }

    private String getStatusString() {
        boolean isEnded = order.getBidding().getActualStatus() == Bidding.STATUS_ENDED;
        String endDate = null;
        if (isEnded) {
            endDate = "test";
//            endDate = DateFormatUtils.getFormattedWithMonth(
//                    CargoDateParser.parse(order.getBidding().getEndDate())
//            );
        }
        String interval = isEnded ? endDate :getDeliveryTime();
        return interval + " " + getStatusText();
    }

    private String getStatusText() {
        int stringResId = R.string.order_waiting_start;
        @Bidding.ActualStatus int statusId = order.getBidding().getActualStatus();
        switch (statusId) {
            case Bidding.STATUS_WAITING_START:
                stringResId = R.string.order_waiting_start;
                break;
            case Bidding.STATUS_WAITING_BID:
                stringResId = R.string.order_waiting_bid;
                break;
            case Bidding.STATUS_ENDED:
                stringResId = order.winOrder() ? R.string.order_won : R.string.order_ended;
                break;
        }
        return getContext().getString(stringResId);
    }


    private String getDeliveryTime() {
        long interval = getTimeBeforeStart();
//        return CargoTimeIntevalFormatter.getFormattedInterval(interval);
        return "test";
    }

    private long getTimeBeforeStart() {
        String date = order.getBidding().getActualStatus() == Bidding.STATUS_WAITING_START ?
                order.getBidding().getStartDate() : order.getBidding().getEndDate();
//        Date startDate = CargoDateParser.parse(date);
//        Date currentDate = App.getServerDate();
//        return Math.abs(currentDate.getTime() - startDate.getTime());
        return 1000;
    }

    private void bindTruckType() {

    }

    private String getLoadingTime() {
//        Date date = CargoDateParser.parse(order.getLoadingTime());
//        SimpleDateFormat format = new SimpleDateFormat("dd MMM", new Locale("ru","RU"));
//        return getContext().getString(R.string.order_loading_time, format.format(date));
        return "test";
    }

    private int getColorByStatus() {
//        int colorResId = R.color.order_status_waiting_start;
//        @Bidding.ActualStatus int statusId = order.getBidding().getActualStatus();
//        switch (statusId) {
//            case Bidding.STATUS_WAITING_START:
//                colorResId = R.color.order_status_waiting_start;
//                break;
//            case Bidding.STATUS_WAITING_BID:
//                colorResId = getTimeBeforeStart() > MIN_INTERVAL ?
//                        R.color.order_status_waiting_bid : R.color.order_status_waiting_bid_less_min;
//                break;
//            case Bidding.STATUS_ENDED:
//                colorResId = order.winOrder() ? R.color.order_status_ended : R.color.order_status_waiting_start;
//                break;
//        }
//        return ContextCompat.getColor(getContext(), colorResId);
        return ContextCompat.getColor(getContext(), R.color.colorAccent);
    }

//    private int getColorStateList() {
//        @Bidding.ActualStatus int statusId = order.getBidding().getActualStatus();
//        switch (statusId) {
//            case Bidding.STATUS_WAITING_START:
//                return R.color.order_btn_state_waiting_start;
//            case Bidding.STATUS_WAITING_BID:
//                int state = R.color.order_btn_state_waiting_bid;
//                if(order.isExpress() && order.getCurrentClientBid() != null) {
//                    state = R.color.order_btn_state_waiting_bid_my;
//                } else if(order.isAuction()) {
//                    state = order.isCurrentBidMine() ?
//                            R.color.order_btn_state_waiting_bid_my : R.color.order_btn_state_waiting_bid;
//                }
//                return state;
//            case Bidding.STATUS_ENDED:
//                return R.color.order_btn_state_ended;
//            default:
//                return R.color.order_btn_state_waiting_bid;
//        }
//    }

    private int getActionButtonNameByStatus() {
        if(order.isAuction()) {
            return order.getCurrentClientBid() == null
                    ? R.string.order_action_auction_bid
                    : R.string.order_action_auction_your_bid;
        } else if(order.getCurrentClientBid() != null) {
            return R.string.order_action_express_bid_mine;
        } else {
            return R.string.order_action_express_bid;
        }
    }

    private int getTypeString(@Bidding.BiddingType int biddingTypeId) {
        switch (biddingTypeId) {
            case Bidding.TYPE_AUCTION:
                return R.string.order_view_auction;
            case Bidding.TYPE_EXPRESS:
                return R.string.order_view_express;
            default:
                return R.string.order_view_auction;
        }
    }


    protected void initViews() {
        initActionButtonContainer();
    }

    private void initActionButtonContainer() {
        actionButton.setVisibility(showActionButton ? VISIBLE : GONE);
    }

    private void handleAttributes(AttributeSet attrs) {
//        TypedArray ta = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.OrderView, 0, 0);
//        try {
//            showActionButton = ta.getBoolean(R.styleable.OrderView_showActionButton, true);
//        } finally {
//            ta.recycle();
//        }
    }

    public View getPriceView() {
        return priceView;
    }

    public View getTypeVew() {
        return typeView;
    }

    public View getFavoriteVew() {
        return favoriteIconView;
    }
}
