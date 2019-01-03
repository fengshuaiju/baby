package com.feng.baby.adapter.platform;

import com.feng.baby.application.command.CreateGoodsCommand;
import com.feng.baby.application.command.GoodsPutOnOffCommand;
import com.feng.baby.application.command.UpdateCutDownGoodsInfoCommand;
import com.feng.baby.application.command.UpdatePriceCommand;
import com.feng.baby.application.representation.BasicInfo;
import com.feng.baby.application.representation.GoodsCutDownInfo;
import com.feng.baby.application.representation.GoodsPriceEdit;
import com.feng.baby.application.service.GoodsService;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/shop/goods/platform")
public class PlatformGoodsController {

    private final GoodsService goodsService;

    @Autowired
    public PlatformGoodsController(GoodsService goodsService){
        this.goodsService = goodsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGoods(@RequestBody CreateGoodsCommand command){
        goodsService.createGoods(command.getCategoryId(), command.getName(), command.getCharacteristic(),
                command.getImagePath(), command.getIsSupportGroup(), command.getIsSupportCutDown(),
                command.getRemark(), command.getContent(), command.getProperties());
    }

    @GetMapping("/search")
    public Page<BasicInfo> platformSearch(@RequestParam(required = false) String keyWord,
                                          @RequestParam(required = false) String categoryId,
                                          Pageable pageable) {
        return goodsService.platformSearch(keyWord, categoryId, pageable);
    }

    @PutMapping("/pull-on-off")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void pullOnOff(@RequestBody GoodsPutOnOffCommand command){
        goodsService.pullOnOff(command.getGoodsId(), command.getStatus());
    }

    @PutMapping("/pull-on-off-grouping")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void pullOnOffGrouping(@RequestBody GoodsPutOnOffCommand command){
        goodsService.pullOnOffGrouping(command.getGoodsId(), command.getGrouping());
    }


    @GetMapping("/price")
    @ResponseStatus(HttpStatus.OK)
    public List<GoodsPriceEdit> getPrice(@RequestParam String goodsId){
        return goodsService.getPrice(goodsId);
    }

    @PutMapping("/price")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePrice(@RequestBody UpdatePriceCommand command){
        goodsService.updatePrice(command.getPriceId(), command.getPrice());
    }


    @GetMapping("/new-price-property")
    public List<GoodsPriceEdit> showNewPriceProperty(@RequestParam String goodsId){
        return goodsService.showNewPriceProperty(goodsId);
    }

    @PostMapping("/price")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addNewPrice(@RequestBody List<GoodsPriceEdit> preToAddPrice){
        goodsService.addNewPrice(preToAddPrice);
    }

    @GetMapping("/cut-down-infos")
    public Page<GoodsCutDownInfo> getCutDownGoodsInfo(@RequestParam(defaultValue = "") String name, Pageable pageable){
        return goodsService.getCutDownsInfo(name, pageable);
    }

    @PutMapping("/cut-down-infos")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCutDownGoodsInfo(@RequestBody UpdateCutDownGoodsInfoCommand command){
        goodsService.updateCutDownGoodsInfo(command.getGoodsId(), command.getMaxAmountPerCut(), command.getMinAmountPerCut(),
                command.getEffectiveTime(), command.getMaxCutDown(), command.getMaxHelper());
    }

    @GetMapping("/goodsNames")
    @ResponseStatus(HttpStatus.OK)
    public List<ImmutableMap<String, String>> getGoodsNames(){
        Map<String, String> goodsNames = goodsService.getGoodsNames();
        return goodsNames.entrySet().stream().map(name -> ImmutableMap.of("value", name.getKey(), "label", name.getValue())).collect(Collectors.toList());
    }

}
