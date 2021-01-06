package io.metersphere.track.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.metersphere.base.domain.LoadTest;
import io.metersphere.commons.utils.PageUtils;
import io.metersphere.commons.utils.Pager;
import io.metersphere.track.request.testplan.LoadCaseRequest;
import io.metersphere.track.service.TestPlanLoadCaseService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/test/plan/load/case")
@RestController
public class TestPlanLoadCaseController {

    @Resource
    private TestPlanLoadCaseService testPlanLoadCaseService;

    @PostMapping("/relevance/list/{goPage}/{pageSize}")
    public Pager<List<LoadTest>> relevanceList(@PathVariable int goPage, @PathVariable int pageSize, @RequestBody LoadCaseRequest request) {
        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, testPlanLoadCaseService.relevanceList(request));
    }

    @PostMapping("/relevance")
    public void relevanceCase(@RequestBody LoadCaseRequest request) {
        testPlanLoadCaseService.relevanceCase(request);
    }

    @PostMapping("/list/{goPage}/{pageSize}")
    public Pager<List<LoadTest>> list(@PathVariable int goPage, @PathVariable int pageSize, @RequestBody LoadCaseRequest request) {
        Page<Object> page = PageHelper.startPage(goPage, pageSize, true);
        return PageUtils.setPageInfo(page, testPlanLoadCaseService.list(request));
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        testPlanLoadCaseService.delete(id);
    }
}
