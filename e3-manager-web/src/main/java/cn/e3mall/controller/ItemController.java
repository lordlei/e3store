package cn.e3mall.controller;



import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    @RequestMapping("item/{itemId}")
    @ResponseBody//@ResponseBody返回的对象自动封装成json
    // @PathVariable是用来对指定请求的URL路径里面的变量
    public TbItem getItemById(@PathVariable Long itemId){

        TbItem tbItem = itemService.getItemById(itemId);

        return tbItem;
    }

    /**
     * 查询分页
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){

        EasyUIDataGridResult list = itemService.getItemList(page, rows);

        return list;
    }
}
