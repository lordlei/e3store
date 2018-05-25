package cn.e3mall.service.impl;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;


    @Override
    public TbItem getItemById(Long itemId) {
        //逆向工程  通过主键查
//        TbItem tbItem = tbItemMapper.selectByPrimaryKey(741524L);
//        通过 条件查
        TbItemExample example = new TbItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
//        通过条件查就会返回list集合 ,取第一个值
        List<TbItem> tbItems = tbItemMapper.selectByExample(example);

        if (tbItems!=null && tbItems.size()>0){
            return tbItems.get(0);
        }
        return null;
    }

    /**
     * 查询分页
     */
    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
//        查询之前设置分页(0,30)
        PageHelper.startPage(page,rows);
//        执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);
        EasyUIDataGridResult gridResult = new EasyUIDataGridResult();
        gridResult.setRows(list);
        gridResult.setTotal(info.getTotal());
        return gridResult;
    }


}
