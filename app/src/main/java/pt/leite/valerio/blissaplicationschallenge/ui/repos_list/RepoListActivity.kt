package pt.leite.valerio.blissaplicationschallenge.ui.repos_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_repo_list.*
import pt.leite.valerio.blissaplicationschallenge.R
import pt.leite.valerio.blissaplicationschallenge.ui.base.BlissBaseActivity
import pt.leite.valerio.blissaplicationschallenge.ui.repos_list.adapters.RepoItemAdapter
import pt.leite.valerio.blissaplicationschallenge.utils.setupPagination

class RepoListActivity : BlissBaseActivity<RepoListActivityViewModel, RepoListActivityViewState, RepoListActivityIntent>() {

    private val repoItemAdapter by lazy { RepoItemAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)

        callIntent(RepoListActivityIntent.LoadListIntent(false))

        LinearLayoutManager(this).apply {
            rvRepos.layoutManager = this
            rvRepos.adapter = repoItemAdapter
            rvRepos.setupPagination(this) {
                if (!viewModel.viewState.isLoading) {
                    callIntent(RepoListActivityIntent.LoadListIntent(true))
                }
            }
        }
    }

    override fun viewModelClass() = RepoListActivityViewModel::class.java

    override fun render(viewState: RepoListActivityViewState) {
        pgRepos.isVisible = viewState.isLoading
        rvRepos.isVisible = (!viewState.isLoading || viewState.isLoadingMore)

        viewState.repoUIList?.let {
            if (viewState.isLoadingMore) {
                repoItemAdapter.addItems(it)
            } else {
                repoItemAdapter.setItems(it)
            }
        }

        viewState.error?.let {
            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        fun startActivity(context: Context?) {
            context?.startActivity(Intent(context, RepoListActivity::class.java))
        }
    }
}